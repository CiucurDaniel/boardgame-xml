package uvt.homework4;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.InetSocketAddress;

public class XSLTApplication {

    private static String BOARDGAME_XML_PATH = "/Users/daniel/Documents/GitHub/boardgame-xml/boardgame.xml";
    public static void main(String[] args) {
        try {
            // Set up the Transformer
            TransformerFactory factory = TransformerFactory.newInstance();

            Transformer transformer = factory.newTransformer(new StreamSource("/Users/daniel/Documents/GitHub/boardgame-xml/src/main/java/uvt/homework4/manufacturer.xslt"));
            Transformer transformerDiscounts = factory.newTransformer(new StreamSource("/Users/daniel/Documents/GitHub/boardgame-xml/src/main/java/uvt/homework4/discount.xslt"));
            Transformer transformerSearch = factory.newTransformer(new StreamSource("/Users/daniel/Documents/GitHub/boardgame-xml/src/main/java/uvt/homework4/searchByCategoryAndPrice.xslt"));
            Transformer transformerIndex = factory.newTransformer(new StreamSource("/Users/daniel/Documents/GitHub/boardgame-xml/src/main/java/uvt/homework4/index.xslt"));

            // Create HTTP server
            HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);

            // Create context and set handler
            server.createContext("/", new IndexHandler(transformerIndex));
            server.createContext("/manufacturer", new ManufacturerHandler(transformer));
            server.createContext("/discounts", new DiscountsHandler(transformerDiscounts));
            server.createContext("/searchByCategoryAndPrice", new SearchByCategoryAndPriceHandler(transformerSearch));

            // Start the server
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class IndexHandler implements HttpHandler {
        private final Transformer transformer;

        public IndexHandler(Transformer transformer) {
            this.transformer = transformer;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            try {
                // Apply the transformation for index.xslt
                String emptyXml = "<empty/>";
                Source xmlSource = new StreamSource(new StringReader(emptyXml));

                StringWriter htmlOutput = new StringWriter();
                transformer.transform(xmlSource, new StreamResult(htmlOutput));

                // Send the HTML response
                String response = htmlOutput.toString();
                exchange.sendResponseHeaders(200, response.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            } catch (TransformerException e) {
                e.printStackTrace();
                exchange.sendResponseHeaders(500, 0); // Internal Server Error
            } finally {
                exchange.close();
            }
        }
    }

    static class ManufacturerHandler implements HttpHandler {
        private final Transformer transformer;

        public ManufacturerHandler(Transformer transformer) {
            this.transformer = transformer;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            try {
                // Apply the transformation
                Source xmlSource = new StreamSource(BOARDGAME_XML_PATH);
                StringWriter htmlOutput = new StringWriter();
                transformer.transform(xmlSource, new StreamResult(htmlOutput));

                // Send the HTML response
                String response = htmlOutput.toString();
                exchange.sendResponseHeaders(200, response.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            } catch (TransformerException e) {
                e.printStackTrace();
                exchange.sendResponseHeaders(500, 0); // Internal Server Error
            } finally {
                exchange.close();
            }
        }
    }

    static class DiscountsHandler implements HttpHandler {
        private final Transformer transformer;

        public DiscountsHandler(Transformer transformer) {
            this.transformer = transformer;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            try {
                // Apply the transformation for boardgames_with_discount.xslt
                Source xmlSource = new StreamSource(BOARDGAME_XML_PATH);
                StringWriter htmlOutput = new StringWriter();
                transformer.transform(xmlSource, new StreamResult(htmlOutput));

                // Send the HTML response
                String response = htmlOutput.toString();
                exchange.sendResponseHeaders(200, response.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            } catch (TransformerException e) {
                e.printStackTrace();
                exchange.sendResponseHeaders(500, 0); // Internal Server Error
            } finally {
                exchange.close();
            }
        }
    }

    static class SearchByCategoryAndPriceHandler implements HttpHandler {
        private final Transformer transformer;

        public SearchByCategoryAndPriceHandler(Transformer transformer) {
            this.transformer = transformer;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            try {
                // Extract category and price parameters from the query
                String query = exchange.getRequestURI().getQuery();
                String category = getParameter(query, "category");
                String priceStr = getParameter(query, "price");
                double price = Double.parseDouble(priceStr);

                // Apply the transformation for search_by_category_and_price.xslt
                Source xmlSource = new StreamSource(BOARDGAME_XML_PATH);

                // Pass parameters to the transformer
                transformer.setParameter("category", category);
                transformer.setParameter("price", price);

                StringWriter htmlOutput = new StringWriter();
                transformer.transform(xmlSource, new StreamResult(htmlOutput));

                // Send the HTML response
                String response = htmlOutput.toString();
                exchange.sendResponseHeaders(200, response.length());
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response.getBytes());
                }
            } catch (TransformerException | NumberFormatException e) {
                e.printStackTrace();
                exchange.sendResponseHeaders(500, 0); // Internal Server Error
            } finally {
                exchange.close();
            }
        }

        // Helper method to extract parameter values from the query string
        private String getParameter(String query, String paramName) {
            String[] params = query.split("&");
            for (String param : params) {
                String[] pair = param.split("=");
                if (pair.length == 2 && pair[0].equals(paramName)) {
                    return pair[1];
                }
            }
            return "";
        }
    }
}
