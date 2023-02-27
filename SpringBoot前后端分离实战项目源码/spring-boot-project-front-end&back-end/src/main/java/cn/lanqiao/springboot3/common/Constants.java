package cn.lanqiao.springboot3.common;

/**
 * @author 13
 * @qq交流群 784785001
 * @email 2449207463@qq.com
 * @link http://13blog.site
 */
public class Constants {

    public static final int RESULT_CODE_SUCCESS = 200;  // 成功处理请求
    public static final int RESULT_CODE_BAD_REQUEST = 412;  // 请求错误
    public static final int RESULT_CODE_NOT_LOGIN = 402;  // 未登录
    public static final int RESULT_CODE_PARAM_ERROR = 406;  // 传参错误
    public static final int RESULT_CODE_SERVER_ERROR = 500;  // 服务器错误

    //public final static String FILE_UPLOAD_PATH = "D:\\upload\\";//上传文件的保存地址，根据部署设置自行修改
    public final static String FILE_UPLOAD_PATH = "/home/project/upload/";//上传文件的保存地址，根据部署设置自行修改

}
