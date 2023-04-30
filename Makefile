build:
	./gradlew clean build

run:
	java -jar $(shell ls -1 build/libs/*.jar | grep -v -- -plain | sort -n | head -n 1)

all: build run