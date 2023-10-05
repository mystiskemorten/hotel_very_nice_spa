hentSpaTilgangForGjestMed(navn) {
  sql = """SELECT * FROM spa_tilgang WHERE gjest_navn = ${navn}"""

  databaseRader = db(sql)
  resultat = databaseRader.tilSpaTilgang()
  return resultat
}

@GET("http://hotell/spa/tilgang?gjest_navn={navn}") {
	spaTilgang = hentSpaTilgangForGjestMed(navn)
	return spaTilgang
}
