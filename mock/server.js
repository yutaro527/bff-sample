const jsonServer = require('json-server')
const server = jsonServer.create()
const router = jsonServer.router('db.json')
const middlewares = jsonServer.defaults()

// Middleware(前処理)
server.use(middlewares)
server.use((req, res, next) => {
    if (req.method === 'POST') {
        req.method = 'GET'
    }
    next()
})

// ルーティングを使用する場合はここに書く
server.use(jsonServer.rewriter({}))
server.use(router)

// 後処理
router.render = function (req, res) {
    let data = res.locals.data
    if (Array.isArray(data)) {
        res.send({contents: data, limit: 10, offset: 0, totalCount: 100})
    } else if (!Object.keys(data).length) {
        res.status(404).send({
            message: "Not Found"
        })
    } else {
        res.send(data)
    }
}

// モックサーバ起動
server.listen(3000, () => {
    console.log('JSON Server is running')
})