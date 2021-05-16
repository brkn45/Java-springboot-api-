web:java $JAVA_OPTS -cp target/classes:target/dependency/* com.mtm.api.Main
web: java -jar $JAVA_OPTS -Dserver.port=$PORT target/country-api.jar
const PORT=process.env.PORT || '8080'

app= express();
app.set("port",PORT);