set JUNIT_CLASSPATH=C:\Users\Public\librairies\junit4-13.2.jar
set HAMCREST_CLASSPATH=C:\Users\Public\librairies\hamcrest-core-1.3.jar
javac -cp C:\Users\Public\librairies\junit4-13.2.jar;. AventurierTest.java
java -cp C:\Users\Public\librairies\junit4-13.2.jar;C:\Users\Public\librairies\hamcrest-core-1.3.jar;. org.junit.runner.JUnitCore AventurierTest