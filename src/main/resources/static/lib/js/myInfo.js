//注意：导航 依赖 element 模块，否则无法进行功能性操作
layui.use('element', function(){
    var element = layui.element;

    //…
});

layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'slider'], function(){
    var laydate = layui.laydate //日期
        ,laypage = layui.laypage //分页
        ,layer = layui.layer //弹层
        ,table = layui.table //表格
        ,carousel = layui.carousel //轮播
        ,upload = layui.upload //上传
        ,element = layui.element //元素操作
        ,slider = layui.slider //滑块

    //执行一个 table 实例
    table.render({
        elem: '#demo'
        ,height: 800
        ,limit:'20'
        ,url: 'classtestes' //数据接口
        ,title: '用户表'
        ,page: true //开启分页
        ,title:'考试信息表'
        ,toolbar: '' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档

        ,cols: [ [ //表头
            {field: 'class_grades_card_id', title: '考试编号', width:'28%', sort: true}
            ,{field: 'class_id', title: '班级', width:'15%', sort: true}
            ,{field: 'test_time', title: '考试时间', width:'15%', sort: true}
            ,{field: 'test_describe', title: '描述', width:'15%', sort: true}
        ] ]
    });

//
});