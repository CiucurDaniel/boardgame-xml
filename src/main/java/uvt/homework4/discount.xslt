<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:w3="http://www.w3schools.com">

    <xsl:output method="html" encoding="UTF-8"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Boardgames with Discount</title>
                <style>
                    table {
                    border-collapse: collapse;
                    width: 100%;
                    }
                    th, td {
                    border: 1px solid black;
                    padding: 8px;
                    text-align: left;
                    }
                </style>
            </head>
            <body>
                <h1>Boardgames with Discount</h1>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Release Date</th>
                        <th>Price</th>
                        <th>Discount</th>
                    </tr>
                    <xsl:apply-templates select="//w3:boardgame"/>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="w3:boardgame">
        <tr>
            <td><xsl:value-of select="@ID"/></td>
            <td><xsl:value-of select="w3:name"/></td>
            <td><xsl:value-of select="w3:releaseDate"/></td>
            <td><xsl:value-of select="w3:price"/></td>
            <!-- Calculate and display the discount -->
            <td><xsl:value-of select="format-number(w3:price * 0.85, '#.##')"/> (15%)</td>
        </tr>
    </xsl:template>

</xsl:stylesheet>
