<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" encoding="UTF-8"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Boardgame Shop</title>
                <style>
                    body {
                    font-family: Arial, sans-serif;
                    text-align: center;
                    margin: 50px;
                    }
                    h1 {
                    color: #1e4bae;
                    }
                    button {
                    padding: 10px 20px;
                    font-size: 16px;
                    margin: 10px;
                    }
                </style>
            </head>
            <body>
                <h1>Boardgame Shop</h1>
                <button onclick="location.href='/manufacturer'">Manufacturer Page</button>
                <button onclick="location.href='/discounts'">Discounts Page</button>
                <button onclick="location.href='/searchByCategoryAndPrice'">Search Page</button>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
