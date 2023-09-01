import requests
from bs4 import BeautifulSoup
import csv

# URL da página da Wikipedia
url = "https://en.wikipedia.org/wiki/List_of_countries_by_population_(United_Nations)"

# Fazer a solicitação HTTP para a página
response = requests.get(url)

# Verificar se a solicitação foi bem-sucedida
if response.status_code == 200:
    # Analisar o conteúdo HTML da página
    soup = BeautifulSoup(response.text, 'html.parser')

    # Encontrar a tabela que contém os dados
    tabela = soup.find('table', {'class': 'wikitable'})

    # Inicializar listas para armazenar os países e as populações
    paises = []
    populacoes = []

    # Iterar pelas linhas da tabela (ignorando o cabeçalho)
    linhas = tabela.find_all('tr')[1:]  # Ignora a primeira linha (cabeçalho)
    for linha in linhas:
        colunas = linha.find_all('td')
        if len(colunas) >= 2:  # Certifique-se de que há pelo menos duas colunas
            # O nome do país está na segunda coluna
            pais = colunas[1].text.strip()
            # A população está na terceira coluna
            populacao = colunas[2].text.strip()

            # Adicione os dados às listas
            paises.append(pais)
            populacoes.append(populacao)

    # Escreva os dados em um arquivo CSV
    with open('dados.csv', 'w', newline='', encoding='utf-8') as arquivo_csv:
        writer = csv.writer(arquivo_csv)

        # Escreva o cabeçalho
        writer.writerow(["País", "População"])

        # Escreva os dados
        for pais, populacao in zip(paises, populacoes):
            writer.writerow([pais, populacao])

    print("Dados transformados em CSV e armazenados em dados.csv.")

else:
    print("Erro ao acessar a página da Wikipedia.")
