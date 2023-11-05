package uvt.homework.xml.website;

import uvt.homework.xml.models.Boardgame;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class WebsiteBuilder {
    public void generateWebsite(ArrayList<Boardgame> boardgames) throws IOException {
        FileWriter fileWriter = new FileWriter("index.html");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(this.obtainHeader());

        for (Boardgame b : boardgames) {
            String content = String.format("""
                            <li>
                            <div class="card mb-3" style="max-width: 540px;">
                              <div class="row g-0">
                                <div class="col-md-4">
                                  <img src="https://assetsio.reedpopcdn.com/catan-board-game-layout.jpg?width=1920&height=1920&fit=bounds&quality=80&format=jpg&auto=webp" class="img-fluid rounded-start" alt="boardgame_image">
                                </div>
                                <div class="col-md-8">
                                  <div class="card-body">
                                    <h5 class="card-title">%s</h5>
                                    <p class="card-text"><small class="text-body-secondary">%d lei</small></p>
                                  </div>
                                </div>
                              </div>
                            </div>
                            </li>
                            """,
                    b.getName(),
                    b.getPrice());

            printWriter.print(content);
            //System.out.println("Current element being generated: " + b.getName());
        }
        printWriter.print(this.obtainFooter());
        printWriter.close();
    }

    private String obtainHeader() throws IOException {
        return new String(Files.readAllBytes(Paths.get("/Users/daniel/IdeaProjects/boardgame-xml/src/main/java/uvt/homework/xml/website/head.html")));
    }

    private String obtainFooter() throws IOException {
        return new String(Files.readAllBytes(Paths.get("/Users/daniel/IdeaProjects/boardgame-xml/src/main/java/uvt/homework/xml/website/bottom.html")));
    }
}
