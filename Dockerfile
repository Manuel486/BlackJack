FROM openjdk:17
ADD ./out/artifacts/blackjack_jar/blackjack.jar blackjack01.jar
ENTRYPOINT ["java","-jar","/blackjack01.jar"]