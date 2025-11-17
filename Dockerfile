FROM ubuntu:latest
LABEL authors="elhou"

ENTRYPOINT ["top", "-b"]