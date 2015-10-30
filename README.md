# FragmentMixViewPager
Fragment的嵌套。子Fragment使用ViewPager进行切换。
   
   在开发过程中，经常使用到Fragment, 有时候会涉及到Fragment的嵌套和ViewPager的联合使用，对于这个场景，发现开源中国客户端实现的很不错。于是从那个大工程中，剥离出这个小demo，做了些修改，方便自己以后有需要时使用。开源中国的完整项目：
   
   https://git.oschina.net/oschina/android-app
   
   工程中使用了BaseFragmentTabHost这个改写的类，解决了原生FragmentTabHost无法隐藏Fragment的问题。
   
   ![image](https://github.com/weijianfeng/FragmentMixViewPager/blob/master/readme.gif) 
