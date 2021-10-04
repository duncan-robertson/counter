FROM azul/zulu-openjdk-alpine:11

RUN mkdir -p /opt/counter
WORKDIR /opt/counter

# Copies the repo files from the build context into the image
COPY . .

EXPOSE 8080

CMD ["./mvnw", "spring-boot:run"]
