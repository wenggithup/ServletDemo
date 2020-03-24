## ajax：asynchrnoized javaScript and xml 异步js和xml
    * jquey实现方式：
        1、$.ajax()
            * 语法：$.ajax({
                            url:"ServletDemo/ajaxServlet" 请求路径,
                            type:"POST" 请求类型，有GET和POST两种,
                            data:({"username":"jack","age":23}) 参数,
                            success:function (data) { 回调函数，服务器成功响应的回调函数
                                              alert(data)
                                          }})
                            error:function，回调函数，服务器失败响应的回调函数
        2、$.get():发送get请求
            * 语法：$.get(url,[data],[callback],[type])
                * 参数：
                    * url:请求路径
                    * data：请求参数
                    * callback：回调函数
                    * type：响应结果类型

        3、$.post()，同$.get

## JSON
    1、概念：JavaScript Object Notation js对象表示法
    2、语法：
        1、基本规则：
            数据在名称/值对中：json数据是由键值对构成
                * 键用引号（单双都行）引起来，也可以不使用引号
            数据由由逗号分隔：多个键值对由逗号分隔
            花括号保存对象：使用{}定义json格式
            方括号保存数据:[]
        2、获取数据：
            1、json对象.键值
            2、json对象["键值"]
            3、js[索引]
        3、Json数据和Java对象的相互转换
            * 解析器：
                常见Json解析器：Jsonlib，Gson，fastJson，jackson
            1、Json转为java对象
            2、java对象转为json
                1、导入jackson jar包
                2、创建jackson核心对象，ObjectMapper
                3、调用ObjectMapper的相关方法进行转换
                    1、方法
                    * writeValue（参数1，obj）
                        * 参数1：
                            File：将obj对象转换成json字符串，并保存到指定的文件中
                            writer：将obj对象转换为json字符串，并将json数据填充到字符输出流中
                            outputStream：将obj对象转换为JSOn字符串，并将json数据填充到字节输出流中
                    * writeValueAsString（obj）：将对象转为json对象
                    2、注解：
                        1、@JsonIgnore：排除属性
                        2、@JsonFormat：属性值得格式化，pattern="格式化类型"
        4、案例：
            注意：
                1、服务器相应的数据，在客户端使用时，要想当作json数据格式使用
                    1、$.get(type)指定type类型为"json"
                    2、在服务器端设置MIME类型
                        response.setContentType("application/json";charset=utf-8)
