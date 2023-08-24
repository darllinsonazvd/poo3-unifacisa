import requests
import json

request = requests.get(f"https://www.omdbapi.com/?t=Avengers&apikey=ea43bac1")

response = request.json()

data = {
    "title": response["Title"],
    "year": response["Year"],
    "genre": response["Genre"],
    "plot": response["Plot"],
    "imgUrl": response["Poster"],
    "ratings": response["Ratings"],
}

# Salvando os dados do filme em um arquivo JSON
with open("data.json", "w") as file:
    json.dump(data, file, indent=2)

print("Os dados do filme foram salvos com sucesso no arquivo data.json")
