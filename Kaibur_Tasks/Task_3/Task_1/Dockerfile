# Use an official Python runtime as a parent image
FROM python:3.9

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Install any needed packages specified in requirements.txt
RUN pip install --trusted-host pypi.python.org -r requirements.txt

# Set environment variables
ENV MONGO_DB_USERNAME=admin \
    MONGO_DB_PASSWORD=password \
    MONGO_DB_HOST=mongodb \
    MONGO_DB_PORT=27017 \
    MONGO_DB_NAME=mydatabase

# Make port 5000 available to the world outside this container
EXPOSE 5000

# Run app.py when the container launches
CMD ["python", "app.py"]

#code Written by @Arpit Singh - 19BCG10069