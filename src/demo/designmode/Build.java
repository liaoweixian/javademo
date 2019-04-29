package demo.designmode;

class Product
{
        private String basic;
        private String wall;
        private String roofed;

    public String getBasic()
    {
        return basic;
    }

    public void setBasic(String basic)
    {
        this.basic = basic;
    }

    public String getWall()
    {
        return wall;
    }

    public void setWall(String wall)
    {
        this.wall = wall;
    }

    public String getRoofed()
    {
        return roofed;
    }

    public void setRoofed(String roofed)
    {
        this.roofed = roofed;
    }

    @Override
    public String toString() {
        return "Product{" +
                "basic='" + basic + '\'' +
                ", wall='" + wall + '\'' +
                ", roofed='" + roofed + '\'' +
                '}';
    }
}

interface AbstractBuild
{
    /**
     * 打基础
     */
     void  buildBasic();

    /**
     * 砌墙
     */
     void  buildWalls();

    /**
     * 封顶
     */
     void  roofed();

    /**
     * 造房子
     * @return
     */
     Product buildProduct();
}

class ConcreteBuild implements AbstractBuild
{
    private Product product;

    public ConcreteBuild()
    {
        this.product = new Product();
    }

    @Override
    public void buildBasic()
    {
        product.setBasic("打好基础");
    }

    @Override
    public void buildWalls()
    {
        product.setWall("砌墙");
    }

    @Override
    public void roofed()
    {
        product.setRoofed("封顶大吉");
    }

    @Override
    public Product buildProduct()
    {
        return product;
    }
}

public class Build {

    public static Product constructProduct(ConcreteBuild concreteBuilder)
    {
        concreteBuilder.buildBasic();
        concreteBuilder.buildWalls();
        concreteBuilder.roofed();
        return concreteBuilder.buildProduct();
    }

    public static void main(String[] args)
    {
        ConcreteBuild build = new ConcreteBuild();
        Product product =  Build.constructProduct(build);
        System.out.println(product);
    }
}
