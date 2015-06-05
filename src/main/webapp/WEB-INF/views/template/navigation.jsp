        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">Sparepart Management</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="#"><i class="fa fa-folder-open fa-fw"></i> License Management<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">                            	
                                <li>
                                    <a href="#">License Inventory<span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                    	<li>
                                    		<a href="#">License Overview</a>
                                    	</li>	
                                    	<li>
                                    		<a href="/sparepart/license?new">Create License</a>
                                    	</li>
                                    	<li>
                                    		<a href="/sparepart/license/records">Manage License</a>
                                    	</li>
                                    	<li>
                                    		<a href="/sparepart/license/assignment">Apply License</a>
                                    	</li>
                                    	<li>
                                    		<a href="/sparepart/license/assignment/records">Release License</a>
                                    	</li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#">Host Inventory<span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                    	<li>
                                    		<a href="/sparepart/host?new">Create Host</a>
                                    	</li>
                                    	<li>
                                    		<a href="/sparepart/host/records">Manage Host</a>
                                    	</li>
                                    </ul>
                                </li>
                            </ul>
                            <!-- /.nav- License Management -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>