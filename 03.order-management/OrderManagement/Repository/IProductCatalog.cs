using OrderManagement.Domain;

namespace OrderManagement.Repository
{
    public interface IProductCatalog
    {
        Product GetByName(string name);
    }
}
