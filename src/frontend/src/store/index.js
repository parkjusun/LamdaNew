import Vue from 'vue'
import Vuex from 'vuex'
import crawling from "./crawling";
import find from "./find";
import movie from "./movie";

Vue.use(Vuex)
export const store = new Vuex.Store({
       modules:{
              crawling,find,movie
       }
})