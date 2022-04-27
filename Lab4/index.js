const express = require("express");
const fs = require("fs");
const path = require("path");

const app = express();

var obj = JSON.parse(fs.readFileSync("books.json", "utf8"));

app.use(express.json({ limit: "10mb" }));
app.use(express.urlencoded({ extended: false }));

app.get("/books", (req, res) => {
    res.json(obj);
});

app.get("/books/:id", (req, res) => {
    res.json(obj[req.params.id]);
});

app.use(express.static(path.join(__dirname, "./client")));

const PORT = process.env.PORT || 3000;

app.listen(PORT, () => {
    console.log("server is up on port " + PORT);
});
