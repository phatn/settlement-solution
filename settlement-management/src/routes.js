import Dashboard from "views/Dashboard.js";
import CreateSettlement from 'views/Create.js';
import SearchSettlement from "views/Search";

const dashboardRoutes = [
  {
    path: "/dashboard",
    name: "Dashboard",
    icon: "nc-icon nc-chart-pie-35",
    component: Dashboard,
    layout: "/admin",
  },
  {
    path: "/create",
    name: "Create",
    icon: "nc-icon nc-simple-add",
    component: CreateSettlement,
    layout: "/admin",
  },
  {
    path: "/search",
    name: "Search",
    icon: "nc-icon nc-zoom-split",
    component: SearchSettlement,
    layout: "/admin",
  }
];

export default dashboardRoutes;
