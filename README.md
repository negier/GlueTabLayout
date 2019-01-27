# GlueTabLayout
能精确修改`TabLayout`的**下划线**指示器的**宽度**，能使用**粘动动画**。

## 效果
<img src="https://github.com/negier/GlueTabLayout/blob/master/screenshots/gluetablayout.gif" width="40%" height="40%" />

## 预览
[example-release.apk](https://github.com/negier/GlueTabLayout/releases/download/v1.0/example-release.apk)

## 使用
`GlueTabLayout`本质就是`TabLayout`，是在`TabLayout`的基础上**添加**了两个重要的功能，所以，您怎么用`TabLayout`，就可以怎么用`GlueTabLayout`，那么接下来
我描述一下我新增加的这两个功能及用法。

1.请先在`build.gradle`中添加依赖：
```
implementation 'com.android.support:design:28.0.0'
```
2.现在您可以将我项目中`Library`下的`GlueTabLayout`拷进您的项目中使用了。（这步别忘了哟）

### 添加的功能方法：
#### ① 修改下划线指示器宽度

```
//设置下划线指示器的宽度为原来的一半
GlueTabLayout.setTabIndicatorWidth(0.5f);
```
#### ② 修改下划线指示器动画
为更好的满足可能的需求我将动画分为三类，下面会介绍，并写了两个方法用来**分别设置滑动的时候下划线指示器的动画**和**点击的时候下划线指示器的动画**。
* `GLUE` 全粘动动画 **默认**
* `HALF_GLUE` 半粘动动画
* `NONE` 无动画
##### 设置滑动的时候下划线指示器的动画:
```
GlueTabLayout.setSlidingIndicatorAnimType(GlueTabLayout.AnimType.GLUE);
```
##### 设置点击的时候下划线指示器的动画:
```
GlueTabLayout.setClickIndicatorAnimType(GlueTabLayout.AnimType.GLUE);
```

