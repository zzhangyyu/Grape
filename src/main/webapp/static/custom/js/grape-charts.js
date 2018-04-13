function showMounthDatas() {
    // 初始化echarts实例
    var myChart = echarts.init(document.getElementById("chartExample"));
    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '就诊人数-月视图',
            x: 'center'
        },
        tooltip: {},
        legend: {
            data: ['就诊人数'],
            x: 'right'
        },
        xAxis: {
            data: ["2018-01", "2018-02", "2018-03", "2018-04", "2018-05", "2018-06"]
        },
        yAxis: {},
        series: [{
            name: '就诊人数',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20]
        }]
    };
    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}