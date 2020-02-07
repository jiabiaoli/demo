axios.defaults.baseURL = '/btm/';
Vue.http = Vue.prototype.$http = axios;
Vue.prototype.$IVIEW={
    size: 'default',
    transfer: true
}
function copy(target,source){
    for(let key in target){
        target[key]=source[key];
    }
}

function reset(json) {
    for(let key in json){
        json[key]   ='';
    }
}

function join(array,spit){
    let str="";
    if(array && array.length>0){
        array.forEach(function (value,index) {
            if(index!=0){
                str+=spit;
            }
            str+=value;
        });
    }
    return str;
}