**验证码的作用**

>验证码的出现可以防止恶意用户利用机器人程序强行注册、登录。从而增加了安全性和减小服务器的压力。

**验证码需要满足的条件**

1. 不同的请求，得到的验证码应该是随机的；或者是无法预知的由服务器端产生。

2. 验证码必须通过人眼识别；防止机器人程序的机器识别。

3. 除人眼识别外，客户端无法通过其他方式获取验证码信息，这也是验证码使用图片不使用文本显示的原因。

**工作流程**

1. 服务器生成随机验证码字符串，保存在session中，并写入图片。将图片连同表单发给客户端。

2. 客户端提交验证码给服务器；服务器获取后进行验证如果相同则允许表单所描述的操作（注册，登录等），如果不同直接将错误信息返回给客户端避免程序的继续运行以及访问数据库等操作。

**实现流程**

1. 在jsp上实现验证码
	
	```
	<%
    response.setHeader("Cache-Control", "no-cache");
    //在内存中创建图像
    int width = 60, height = 20;
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    Graphics g = image.getGraphics();
    g.setColor(new Color(200, 200, 200));
    g.fillRect(0, 0, width, height);
    Random rnd = new Random();
    int randNum = rnd.nextInt(8999) + 1000;
    String randStr = String.valueOf(randNum);
    session.setAttribute("ranStr", randStr);
    g.setColor(Color.black);
    g.setFont(new Font("", Font.PLAIN, 20));
    g.drawString(randStr, 10, 17);
    for (int i = 0; i < 100; i++) {
        int x = rnd.nextInt(width);
        int y = rnd.nextInt(height);
        g.drawOval(x, y, 1, 1);
    }
    ImageIO.write(image,"JPEG",response.getOutputStream());
    out.clear();
    out=pageContext.pushBody();
    %>
	```
2. 提交表单

	![](http://img-blog.csdn.net/20180314162939133?watermark/2/text/Ly9ibG9nLmNzZG4ubmV0L2x1Y2t5OTMyMg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

3. 提交之后对验证码进行验证
	
	```
	/**
    * Project: ValidateCode
    * Created by Zdd on 2018/3/13.
    */
    public class ValidateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String code = req.getParameter("code");
        HttpSession session = req.getSession();
        String ranStr = (String) session.getAttribute("ranStr");
        PrintWriter writer = resp.getWriter();
        if (!code.equals(ranStr)){
            writer.println("验证码错误");
        }else {
            writer.println("验证码正确");
        }
    }
}
	```

----


![](http://img-blog.csdn.net/20180314163157756?watermark/2/text/Ly9ibG9nLmNzZG4ubmV0L2x1Y2t5OTMyMg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)