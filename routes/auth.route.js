const express = require('express');
const router = express.Router();

router.post('/register', async(req, res, next) => {
    res.send("REGISTER POST");
})

router.post('/login', async(req, res, next) => {
    res.send("LOGIN POST");
})

router.post('/logout', async(req, res, next) => {
    res.send("logout POST");
})

router.post('/refresh-token', async(req, res, next) => {
    res.send("refresh-token POST");
})

module.exports = router;