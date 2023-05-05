module.exports={
    devServer:{
        proxy:{
            '/api':{
                // Backend auf 8080 und Frontend 8081 laufen
                target: 'http://localhost:8080',
                ws:true,
                changeOrigin: true
            }
        }
    }
}