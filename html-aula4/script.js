const fruit = `{
  "name": "banana",
  "price": 3.5,
  "types": ["prata", "maça", "da terra", "nanica"],
  "origin": "Brazil",
  "char": "\u3071"
}`

const sports = `[
  {
    "name": "Futebol",
    "origin": "Inglaterra",
    "modalities": [
      "Futebol de campo",
      "Futsal",
      "Futebol de areia",
      "Bossaball",
      "Futevôlei",
      "Futebol society",
      "Showbol",
      "Futebol paralímpico"
    ],
    "morePracticing": "Brasil"
  },
  {
    "name": "Basquete",
    "origin": "Estados Unidos",
    "modalities": [
      "Basquete 5x5",
      "Basquete 3x3",
      "basquete em cadeiras de rodas"
    ],
    "morePracticing": "Estados Unidos"
  },
  {
    "name": "Voleibol",
    "origin": "Estados Unidos",
    "modalities": [
      "Vôlei de quadra",
      "Vôlei de praia",
      "Vôlei sentado"
    ],
    "morePracticing": "Rússia"
  }
]`

const banana = () => {
  console.log(fruit)
  console.log(JSON.parse(fruit))
  console.log(JSON.parse(fruit).origin)
  console.log(JSON.parse(fruit).char)
}

const getSports = () => {
  console.log(sports)
  console.log(JSON.parse(sports))
}
