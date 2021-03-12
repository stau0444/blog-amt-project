module.exports = {
    devServer:{
        historyApiFallback: true,
        proxy:{
            '/api':{
                target:'http://localhost:8090/',
                ws:true,
                changeOrigin:true
            },
        }
    }
}