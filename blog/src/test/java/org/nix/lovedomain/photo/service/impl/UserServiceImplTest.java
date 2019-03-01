package org.nix.lovedomain.photo.service.impl;

//@SpringBootTest(classes = BlogApplication.class)
//@RunWith(value = SpringJUnit4ClassRunner.class)
public class UserServiceImplTest {

//    @Autowired
//    private UserServiceImpl userService;
//
//    @Resource
//    private UserMapper userMapper;
//
//    @Resource
//    private AlbumMapper albumMapper;
//
//    @Resource
//    private PhotoMapper photoMapper;
//
//    @Test
//    public void register() {
//        // 注册
//        User user = new User();
//        user.setNickname("张沛");
//        user.setPassword("bisha520");
//        user.setPhone("1234567890");
//        user.setUsername("admin");
//        userService.register(user);
//    }
//
//    @Test
//    public void addAlbum() {
//        // 添加相册
//        Album album = new Album();
//        UserExample example = new UserExample();
//        example.createCriteria().andUsernameEqualTo("admin");
//        List<User> users = userMapper.selectByExample(example);
//        album.setOwnerid(users.get(0).getId());
//        album.setDescription("第一个相册哎");
//        album.setName("我的开局相册");
//        albumMapper.insertSelective(album);
//    }
//
//    @Test
//    public void addPhoto() {
//        // 存储照片并获取url
//        String pathname = "C:\\Users\\Lenovo\\Desktop\\上海\\IMG_20180716_192802.jpg";
//        File file = new File(pathname);
//        System.out.println(file.getName());
//        FileOssServiceImpl image = new FileOssServiceImpl(new OssProperties(), "zhangpei-bisha-blog");
//        String url = image.upload(file);
//        // 添加照片信息
//        AlbumExample albumExample = new AlbumExample();
//        albumExample.createCriteria().andNameEqualTo("我的开局相册");
//        List<Album> albums = albumMapper.selectByExample(albumExample);
//        Integer id = albums.get(0).getId();
//        Photo photo = new Photo();
//        photo.setDescription("我的第一张图片");
//        photo.setName("风景");
//        photo.setUrl(url);
//        photo.setAlbumid(id);
//        photoMapper.insertSelective(photo);
//    }
//
//    @Resource
//    private PhotoServiceImpl photoService;
//
//    @Resource
//    private AlbumServiceImpl albumService;
//
//    @Test
//    public void selectPhoto() {
//        Album album = albumService.selectAlbumByName("我的开局相册");
//        List<Photo> photos = photoService.selectAlbumInPhotos(album.getId());
//        System.out.println(JSONUtil.toJsonStr(photos));
//    }
//
//    @Test
//    public void addPhotos() {
//        Album album = albumService.selectAlbumByName("我的开局相册");
//        Integer id = album.getId();
//        File file = new File("C:\\Users\\Lenovo\\Desktop\\毕沙照片");
//        File[] files = file.listFiles();
//        for (File photo : files) {
//
//            Photo currPhoto = new Photo();
//
//            currPhoto.setAlbumid(id);
//            currPhoto.setName(photo.getName());
//            currPhoto.setDescription(photo.getName());
//
//            FileOssServiceImpl image = new FileOssServiceImpl(new OssProperties(), "zhangpei-bisha-blog");
//            String url = image.upload(photo);
//            currPhoto.setUrl(url);
//
//            photoMapper.insertSelective(currPhoto);
//        }
//    }
}