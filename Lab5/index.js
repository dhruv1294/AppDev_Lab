const express = require("express");
const fs = require("fs");
const path = require("path");

const app = express();

app.use(express.json({ limit: "10mb" }));
app.use(express.urlencoded({ extended: false }));

app.get("/users", (req, res) => {
    res.sendFile(path.join(__dirname, "./user.xml"));
});

app.use(express.static(path.join(__dirname, "./client")));

const PORT = process.env.PORT || 3000;

app.listen(PORT, () => {
    console.log("server is up on port " + PORT);
});
