import mysql.connector
import csv 
data = csv.reader
data = csv.DictReader(open("./korean_drama.csv", encoding="utf-8"))

print(data)

def openDatabase(host: str, user: str, password: str, database: str):
    return mysql.connector.connect(
        host=host, user=user, password=password, database=database
    )

#Criar a Classe Pessoa
class Functions(Connection):

    #métodos de manipulação de registros
    def insert(self, *args):
        try:
            sql = "INSERT INTO movies (kdrama_id,drama_name,year_release,director,screenwriter,country,type_movie,tot_eps,duration,start_dt,end_dt,aired_on,org_net,content_rt,synopsis,rank_imdb,pop) VALUES (%d, %s, %d, %s, %s, %s, %s, %d, %s, %s, %s, %s, %s, %s, %f, %s, %d, %d)"
            # Usa o método execute da classe base
            self.execute(sql, args)
            self.commit()
        except Exception as e:
            print("Erro ao inserir", e)

    #método inserir_csv
    def insert_csv(self, filename):
        try:
            data = csv.DictReader(open(filename, encoding="utf-8"))
            for row in data:
                self.insert(row["kdrama_id"])
                print("Registro Inserido")
        except Exception as e:
            print("Erro ao inserir csv", e)
    


    #método delete
    def delete(self, id):
        try:
            sql_s = f"SELECT * FROM pessoa WHERE id = {id}"
            if not self.query(sql_s):
                return "Registro não encontrado para deletar"
            sql_d = f"DELETE FROM pessoa WHERE id = {id}"
            self.execute(sql_d)
            self.commit()
            return "Registro deletado"
        except Exception as e:
            print("Erro ao deletar", e)
    
    #método update
    def update(self, id, *args):
        try:
            sql = f"UPDATE pessoa SET nome = %s WHERE id = {id}"
            self.execute(sql, args)
            self.commit()
            print("Registro atualizado")
        except Exception as e:
            print("Erro ao atualizar", e)




