# Install Jenkins
FROM jenkins/jenkins:2.346.1-jdk11
USER root
RUN apt-get update && apt-get install -y lsb-release
RUN curl -fsSLo /usr/share/keyrings/docker-archive-keyring.asc \
  https://download.docker.com/linux/debian/gpg
RUN echo "deb [arch=$(dpkg --print-architecture) \
  signed-by=/usr/share/keyrings/docker-archive-keyring.asc] \
  https://download.docker.com/linux/debian \
  $(lsb_release -cs) stable" > /etc/apt/sources.list.d/docker.list
RUN apt-get update && apt-get install -y docker-ce-cli
USER jenkins
RUN jenkins-plugin-cli --plugins "blueocean:1.25.5 docker-workflow:1.28"

# Installing dependencies
USER root
RUN apt-get install -yqq unzip && apt-get install -y wget

# Install Google Chrome
RUN apt-get update && \
    wget --quiet https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb && \
    (dpkg --install google-chrome-stable_current_amd64.deb || DEBIAN_FRONTEND=noninteractive apt-get --fix-broken --yes install) && \
    rm google-chrome-stable_current_amd64.deb && \
    sed -i 's|HERE/chrome"|HERE/chrome" --disable-setuid-sandbox --no-sandbox|g' "/opt/google/chrome/google-chrome" && \
    google-chrome --version && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/* /usr/share/doc/*

# Install Chromedriver
RUN CHROMEDRIVER_RELEASE=$(curl http://chromedriver.storage.googleapis.com/LATEST_RELEASE) && \
    echo "Chromedriver latest version: $CHROMEDRIVER_RELEASE" && \
    wget --quiet "http://chromedriver.storage.googleapis.com/$CHROMEDRIVER_RELEASE/chromedriver_linux64.zip" && \
    unzip chromedriver_linux64.zip && \
    rm -rf chromedriver_linux64.zip && \
    mv chromedriver /usr/local/bin/chromedriver && \
    chmod +x /usr/local/bin/chromedriver && \
    chromedriver --version

# Install Maven
ARG MAVEN_VERSION=3.8.6
ARG USER_HOME_DIR="/root"

ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/${MAVEN_VERSION}/binaries

RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
  && echo "Downloading maven" \
  && curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
  \
  && echo "Unziping maven" \
  && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
  \
  && echo "Cleaning and setting links" \
  && rm -f /tmp/apache-maven.tar.gz \
  && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

RUN mvn -v
RUN chromedriver --version
RUN google-chrome --version








