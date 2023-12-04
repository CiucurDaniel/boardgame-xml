<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:xs="http://www.w3schools.com">

    <xsl:output method="html" encoding="UTF-8"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Manufacturer Boardgames</title>
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
                <h1>Manufacturer and Boardgames</h1>
                <xsl:apply-templates select="//xs:manufacturer"/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="xs:manufacturer">
        <h2><xsl:value-of select="xs:name"/></h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Release Date</th>
                <th>Price</th>
            </tr>
            <xsl:apply-templates select="//xs:boardgame[@manufacturerID = current()/@manufacturerID]"/>
        </table>
    </xsl:template>

    <xsl:template match="xs:boardgame">
        <tr>
            <td><xsl:value-of select="@ID"/></td>
            <td><xsl:value-of select="xs:name"/></td>
            <td><xsl:value-of select="xs:releaseDate"/></td>
            <td><xsl:value-of select="xs:price"/></td>
        </tr>
    </xsl:template>

</xsl:stylesheet>
