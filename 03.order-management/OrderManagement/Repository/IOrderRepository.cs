using OrderManagement.Domain;

namespace OrderManagement.Repository
{
    public interface IOrderRepository
    {
        void Save(Order order);

        Order GetById(int orderId);
    }
}
