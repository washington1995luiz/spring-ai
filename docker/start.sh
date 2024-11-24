# Starter to Linux and WSL platform

# Download and start image
docker-compose -f docker-compose-ia.yaml up -d

# Run llama3.2:3b
docker exec -it ollama bash -c "ollama run llama3.2:3b"


