// 渲染数据 
// template 模板，data 数据，id 被填充的html元素id
function render(template,data,id){
    $('#'+id).html(template(data));
}