REM Starter to Windows Platform

REM Download and start image
docker-compose -f docker-compose-ia.yaml up -d

REM Run llama3.2:3b
docker exec -it ollama bash -c "ollama run llama3.2:3b"


