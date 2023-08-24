import requests

request = requests.get("https://economia.awesomeapi.com.br/last/USD-BRL,EUR-BRL,BTC-BRL")
print(request)

print(request.json())

response = request.json()
print(response['USDBRL']['bid'])