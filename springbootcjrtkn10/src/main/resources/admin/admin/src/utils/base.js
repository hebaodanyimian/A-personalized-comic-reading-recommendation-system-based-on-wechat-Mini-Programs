const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootcjrtkn10/",
            name: "springbootcjrtkn10",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootcjrtkn10/front/h5/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于微信小程序的个性化漫画阅读推荐系统的设计与实现"
        } 
    }
}
export default base
