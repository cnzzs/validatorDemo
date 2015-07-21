# validatorDemo
对valdate校验器的基本实现,Spring MVC校验器的扩展,可进行对方法参数单个校验 实例

对valdate校验器的基本实现,Spring MVC校验器的扩展,可进行对方法参数单个校验 下面是简单的实现：

@Valid
public Map<String, Object> set(@QQ String qq) {
    System.out.println(qq);
    return successData();
}
 public Map<String, Object> add(@Valid User user) {
    System.out.println(user.getName());
    System.out.println(user.getQq());
    System.out.println(user.getIdCard());
    return successData();
}
