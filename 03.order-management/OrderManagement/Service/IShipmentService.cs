using OrderManagement.Domain;

namespace OrderManagement.Service
{
    public interface IShipmentService
    {
        void Ship(Order order);
    }
}
