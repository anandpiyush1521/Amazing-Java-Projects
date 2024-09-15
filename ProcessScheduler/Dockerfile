# Use the Debian-based OpenJDK base image
FROM openjdk:17-slim

# Install Xvfb for virtual display
RUN apt-get update && apt-get install -y xvfb

# Set the working directory in the container
WORKDIR /app

# Copy the contents of the 'src' directory into the container's '/app/src' directory
COPY src /app/src

# Compile the Java program
RUN javac src/ProcessScheduler.java

# Use Xvfb to create a virtual display and run the application
CMD ["xvfb-run", "java", "-cp", "src", "ProcessScheduler"]
