<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:w3="http://www.w3schools.com">

    <xsl:param name="category"/>
    <xsl:param name="price"/>

    <xsl:output method="html" encoding="UTF-8"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Search by Category and Price Results</title>
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
                <h1>Search by Category and Price Results</h1>
                <p>Category: <xsl:value-of select="$category"/></p>
                <p>Price (less than or equal to): <xsl:value-of select="$price"/></p>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Release Date</th>
                        <th>Price</th>
                    </tr>
                    <xsl:apply-templates select="//w3:boardgame[contains(w3:categoriesIDs, $category) and number(w3:price) &lt;= $price]"/>
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
        </tr>
    </xsl:template>

</xsl:stylesheet>
