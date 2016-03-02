.PHONY : all clean

all : EmiTrustmanagerTester.class

clean :
	-rm -f *.class

EmiTrustmanagerTester.class : EmiTrustmanagerTester.java
	javac -classpath /usr/share/java/bcprov.jar:/usr/share/java/trustmanager.jar:. EmiTrustmanagerTester.java
