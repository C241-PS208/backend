const express = require('express');
const morgan = require('morgan');
const httpErrors = require('http-errors');
require('dotenv').config();

const PORT = process.env.PORT || 3000;
const app = express();
app.use(morgan('dev'));

const routes = require('./routes');
app.use(routes);

app.use(async (req, res, next) => {
    next(httpErrors.NotFound());
});

app.use((err, req, res, next) => {
    res.status(err.status || 500);
    res.send({
        error: {
            status: err.status || 500,
            message: err.message,
        },
    });
});

app.listen(PORT, () => {
    console.log(`Server is currently running on port ${PORT}`);
});
