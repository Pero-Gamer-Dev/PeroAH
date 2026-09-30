package com.peroah.commands;

import com.peroah.PeroAH;
import com.peroah.gui.GuiManager;
import com.peroah.util.Text;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCommand implements CommandExecutor {
    private PeroAH plugin;

    public AdminCommand(PeroAH plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be executed by players!");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            GuiManager.openAuctionHouseGUI(player);
            return true;
        }

        String subcommand = args[0].toLowerCase();

        switch (subcommand) {
            case "create":
                handleCreate(player, args);
                break;
            case "list":
                GuiManager.openAuctionHouseGUI(player);
                break;
            case "mail":
                GuiManager.openMailGUI(player);
                break;
            default:
                player.sendMessage(Text.color("&cUnknown subcommand: &f" + subcommand));
        }

        return true;
    }

    private void handleCreate(Player player, String[] args) {
        if (args.length < 3) {
            player.sendMessage(Text.color("&cUsage: /auctionhouse create <price> <duration>"));
            return;
        }

        try {
            long price = Long.parseLong(args[1]);
            long duration = Long.parseLong(args[2]);
            // Implementation for creating auction
            player.sendMessage(Text.color("&aAuction created!"));
        } catch (NumberFormatException e) {
            player.sendMessage(Text.color("&cPrice and duration must be numbers!"));
        }
    }
}
