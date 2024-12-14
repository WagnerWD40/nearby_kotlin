package com.example.nearby.data.model.mock

import com.example.nearby.data.model.Market

val mockMarkets = listOf(
    Market(
        id = "012576ea-4441-4b8a-89e5-d5f32104c7c4",
        categoryId = "146b1a88-b3d3-4232-8b8f-c1f006f1e86d",
        name = "Sabor Grill",
        description = "Churrascaria com cortes nobres e buffet variado. Experiência completa para os amantes de carne.",
        latitude = -23.55974230991911,
        longitude = -46.65814845249887,
        coupons = 10,
        address = "Av. Paulista - Bela Vista",
        phone = "(11) 94567-1212",
        cover = "https://images.unsplash.com/photo-1498654896293-37aacf113fd9?w=400&h=300",
    ),
    Market(
        id = "4197b830-aa9c-40d4-a22e-c05043588a77",
        categoryId = "146b1a88-b3d3-4232-8b8f-c1f006f1e86d",
        name = "Burguer Up",
        description = "Hambúrgueres gourmet preparados na hora. Ingredientes frescos e combinações únicas.",
        latitude = -23.56011117635681,
        longitude = -46.65636680690605,
        coupons = 10,
        address = "Rua Peixoto Gomide - Jardim Paulista",
        phone = "(13) 98765-4321",
        cover = "https://images.unsplash.com/photo-1528605248644-14dd04022da1?w=400&h=300",
    )
)