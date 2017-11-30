 //使用ehcache案例
 ```$导入jar包
ehcache-2.10.1.jar
log4j-1.2.16.jar
slf4j-api-1.7.7.jar
slf4j-jdk14-1.7.7.jar
slf4j-log4j12-1.7.2.jar
```
 ```
 public List<Category> findAll() throws Exception {
        //获取流
        InputStream is = CategoryServiceImpl.class.getClassLoader().getResourceAsStream("ehcache.xml");

        CacheManager cm = CacheManager.create(is);

        Cache cache = cm.getCache("categoryCache");
        Element element = cache.get("clist");

        List<Category> list = null;

        if (element == null) {
            CategoryDao cd = new CategoryDaoImpl();
            list = cd.findAll();
            cache.put(new Element("clist",list));
        } else {
            list= (List<Category>) element.getObjectValue();
        }
        return list;
    }
 ```