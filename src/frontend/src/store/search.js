import axios from "axios";
import router from '@/router';

const  state = {
    context:`http://localhost:5000/`
}
const actions = {
    async find({commit},searchWord){
        axios.get(state.context+`soccer/`+searchWord)
            .then(({data})=>{
                alert('서버갔다왔음'+data)
                commit('SEARCH',data)
                router.push('/soccer')

            })
            .catch(()=>{
                alert('통신 실패')
            })
    }

}
const  mutations ={
    SEARCH (){}
}


const getters ={

}

export default{
    name:'search',
    namespaced:true,
    state,
    actions,
    getters,
    mutations

}
