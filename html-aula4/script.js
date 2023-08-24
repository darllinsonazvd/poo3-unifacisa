const fruit = `{
  "name": "banana",
  "price": 3.5,
  "types": ["prata", "maça", "da terra", "nanica"],
  "origin": "Brazil",
  "char": "\u3071"
}`

const banana = () => {
  console.log(fruit)
  console.log(JSON.parse(fruit))
  console.log(JSON.parse(fruit).origin)
  console.log(JSON.parse(fruit).char)
}
